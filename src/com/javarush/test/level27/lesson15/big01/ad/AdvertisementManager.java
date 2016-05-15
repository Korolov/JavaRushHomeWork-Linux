package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.*;

/**
 * Created by alexander on 30.03.16.
 */
public  class AdvertisementManager
{
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds=timeSeconds;
    }
    public  void processVideos() throws InterruptedException
    {

        if(storage.list().isEmpty())
            throw new NoVideoAvailableException();
        Set<Advertisement>set=new LinkedHashSet<>(storage.list());








        int count=0;
        ArrayList<Advertisement>videosToShow=new ArrayList<>();
        for(int i=0;i<storage.list().size();i++){
            if(count>=timeSeconds)
                break;
            if(count+storage.list().get(i).getDuration()<=timeSeconds){
                videosToShow.add(storage.list().get(i));
                storage.list().get(i).revalidate();
            }
        }
        if(videosToShow==null||videosToShow.isEmpty())
            throw new NoVideoAvailableException();
        else{
            for(Advertisement video:videosToShow){
                ConsoleHelper.writeMessage(video.getName()+" is displaying... "+video.amountPerOneDisplaying+", "+video.getAmountPerOneDisplaying()*1000/video.getDuration());
                count+=video.getDuration();
                video.revalidate();
                Thread.sleep(video.getDuration());
            }
        }
    }
    public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
        Set<Set<T>> sets = new HashSet<Set<T>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<T>());
            return sets;
        }
        List<T> list = new ArrayList<T>(originalSet);
        T head = list.get(0);
        Set<T> rest = new HashSet<T>(list.subList(1, list.size()));
        for (Set<T> set : powerSet(rest)) {
            Set<T> newSet = new HashSet<T>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }

    public  ArrayList<Advertisement> chooseBestSet(Set set){
        Set<Set<Advertisement>>powerset=powerSet(set);
        Iterator iterator=powerset.iterator();

        while(iterator.hasNext()){
            HashSet e= (HashSet) iterator.next();
            if(e.isEmpty()){
                iterator.remove();
                continue;
            }
            Iterator i2=e.iterator();
            int totalTime=0;
            label:while(i2.hasNext()){
                totalTime+=((Advertisement)i2.next()).getDuration();
                if(totalTime>timeSeconds){
                    iterator.remove();
                    break label;
                }
            }
        }
        ConsoleHelper.writeMessage(powerset.toString());





        return null;
    }

}


