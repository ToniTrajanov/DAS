import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

public class RatingsFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        Worksheet worksheet = workbook.getWorksheets().get(0);

        for (int i = 1; i < worksheet.getRows().length; i++) {
            String text = worksheet.get(i, 2).getText();
            if (text.isBlank()) {
                worksheet.get(i, 2).setValue("0.0");
            }
        }
        for (int i = 1; i < worksheet.getRows().length; i++) {
            String text = worksheet.get(i, 3).getText();
            if (text.isBlank()) {
                worksheet.get(i, 3).setValue("(0)");
            }
        }
        workbook.saveToFile(input, ExcelVersion.Version2013);

        return input;
    }
}
