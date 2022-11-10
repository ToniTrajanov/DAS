


public class PipeAndFilterProblem {
    public static void main(String[] args) {

        Pipe<String> pipe = new Pipe<>();

        CapitalLetterFilter capitalLetterFilter = new CapitalLetterFilter();
        DeleteRowsFilter deleteRowsFilter = new DeleteRowsFilter();
        RatingsFilter ratingsFilter = new RatingsFilter();
        AlignmentFilter alignmentFilter = new AlignmentFilter();
        StreetFilter streetFilter = new StreetFilter();

        pipe.addFilter(deleteRowsFilter);
        pipe.addFilter(capitalLetterFilter);
        pipe.addFilter(ratingsFilter);
        pipe.addFilter(streetFilter);
        pipe.addFilter(alignmentFilter);



        pipe.runFilter("hospitals_data.xlsx");
        pipe.runFilter("pharmacies_data.xlsx");
    }
}