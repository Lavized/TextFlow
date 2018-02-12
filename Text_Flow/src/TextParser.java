import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class TextParser {
    public static void main(String[] args) throws IOException {

        List<List<String>> lists = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String param = reader.readLine();
        String[] params = param.split(" ");
        List<String> listParams = Arrays.asList(params);

        String text;
        while (true) {
            text = reader.readLine();

            if (text.equals("")) {
                break;
            }

            String[] words = text.split(" ");
            List<String> list = Arrays.asList(words);
            lists.add(list);
        }


        for (List<String> list : lists) {
            for (int j = 0; j < list.size(); j++) {
                for (String listParam : listParams) {
                    boolean isRegex;
                    try {
                        Pattern.compile(listParam);
                        isRegex = true;
                    } catch (PatternSyntaxException e) {
                        isRegex = false;
                    }
                    if (isRegex && list.get(j).matches(listParam)) {
                        System.out.println(list.toString().replaceAll("^\\[|]$", "")
                                .replaceAll(",", ""));
                        j = list.size() - 1;
                        break;
                    } else if (!isRegex && list.get(j).equals(listParam)) {
                        System.out.println(list.toString().replaceAll("^\\[|]$", "")
                                .replaceAll(",", ""));
                    }
                }
            }
        }
    }
}
