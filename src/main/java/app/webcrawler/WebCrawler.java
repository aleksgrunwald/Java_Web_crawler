package app.webcrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class WebCrawler {

    public List<String> getLinksFromUrl(String url) throws Exception {
        List<String> foundHrefs = new ArrayList<String>();
        List<String> filteredHrefs = new ArrayList<String>();

        Document webpage = Jsoup.connect(url).get();
        Elements aHrefs = webpage.select("a");
        for (Element link : aHrefs) {
            foundHrefs.add(link.attr("href"));
        }

        foundHrefs.stream()
                .forEach((elem) -> {
                    System.out.print(elem);
//                    if(filteredHrefs.indexOf(elem) == -1) {
//                        filteredHrefs.add(elem);
//                    }
                });
        }


        return foundHrefs;
    }
}