package bai16_io_text_file.thuc_hanh;

import java.io.*;

public class ReadFileExample {
    public void readFileText(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();
            System.out.println("Sum = " + sum);
        } catch (Exception ex) {
            System.err.println("Fie not tồn tại or nội dung có lỗi!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter a file: ");
//        Scanner scanner = new Scanner(System.in);
//        String path = scanner.nextLine();
        String path = "D:\\C0221G1-LeKhanhHa\\module2\\src\\test.test\\test2\\thuc_hanh\\Hello.txt";
        ReadFileExample readFileEx = new ReadFileExample();
        readFileEx.readFileText(path);
    }
}
