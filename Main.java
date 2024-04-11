import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        String t = "IP-95.67.88.52";
        Pattern p = Pattern.compile("(([1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|\\d)\\.){3}([1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|\\d)");
        Matcher f = p.matcher(t);

        String result = f.find() ? f.group() : "Не найдено верного IP-адреса";

        File file = new File("ip_address_info.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("Информация об IP-адресе: " + result);
            System.out.println("Информация успешно записана в файл ip.txt");
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
