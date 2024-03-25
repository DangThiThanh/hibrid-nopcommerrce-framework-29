package phuongHoaXuan;

public class DinhBoLinh {
    //Có access modifier là private thỉ chỉ được dùng trong Class chứa nó
    // Varriable/ property
    private String espresso;
    //Method/ Function
    private String getEspresso(){
        return espresso;
    }
    private void setEspresso( String espresso){
        this.espresso = espresso;
    }

    String capuchino;
    String getCapuchino(){
        return capuchino;
    }
    public static void main(String[] args ){
        // Hàm là
        DinhBoLinh dinhBoLinh = new DinhBoLinh();
        dinhBoLinh.espresso ="miu miu";
        System.out.println(dinhBoLinh.getEspresso());
    }
}
