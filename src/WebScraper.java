
    import java.io.IOException;
    import java.net.URL;
    import java.util.Scanner;

    public class WebScraper {
    public static void main(String[] unused) {
        String url = "http://erdani.com/tdpl/hamlet.txt";
        System.out.println(urlToString(url));
        System.out.println(countSpecificWord(url, "prince"));

    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int countSpecificWord(String url, String word) {
        int startingPoint = 0;
        int count = 0;
        while (url.indexOf(word, startingPoint) != -1) {
            count++;
            startingPoint = url.indexOf(word, startingPoint) + 1;
        }
        return count;
    }

}
