package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexander on 24.05.16.
 */
public class MoikrugStrategy implements Strategy
{
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=%s";


    @Override
    public List<Vacancy> getVacancies(String searchString) {

        List<Vacancy> vacancies = new ArrayList<>();
        int pageNumber = 1;

        try {
            Document doc;

            while (true) {
                //Получаем документ для парсинга и увеличиваем счетчик страниц
                if(pageNumber==1){
                 doc = Jsoup.connect(String.format("https://moikrug.ru/vacancies?q=%s",searchString))
                         .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36")
                         .referrer("none")
                         .get();
                pageNumber++;}
                else
                    doc = getDocument(searchString,pageNumber++);
                //делаем выборку с указанными аттрибутами
                Elements elements = doc.getElementsByClass("job");

                //Если вакансий нет - выходим из цикла
                if (elements.size() == 0) break;

                //парсим
                for (Element element : elements) {

                    //создаем новую вакансию
                    Vacancy vacancy = new Vacancy();
                    Element titleE = element.getElementsByClass("title").first();
                    vacancy.setTitle(titleE.text());
                    Element salaryE = element.getElementsByClass("salary").first();
                    if (salaryE != null)
                    {
                        vacancy.setSalary(salaryE.text());
                    } else
                    {
                        vacancy.setSalary("");
                    }
                    try{Element cityE=element.getElementsByClass("location").first();
                    vacancy.setCity(cityE.text());}
                    catch (NullPointerException e){
                        vacancy.setCity("");
                    }
                    Element companyNameE=element.getElementsByClass("company_name").first();
                    vacancy.setCompanyName(companyNameE.getElementsByTag("a").text());
                    vacancy.setUrl("https://moikrug.ru"+companyNameE.getElementsByTag("a").attr("href"));
                    vacancy.setSiteName("https://moikrug.ru");
                    vacancies.add(vacancy);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return vacancies;
    }
    protected Document getDocument(String searchString, int page) throws IOException
    {
        String url = String.format(URL_FORMAT, page,searchString);
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36")
                .referrer("none")

                .get();
        return doc;
    }
}