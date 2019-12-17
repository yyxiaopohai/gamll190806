public class Simple {
    private Simple(){

    }
    private static Simple simple;
    public static Simple getSimple(){
        if (simple==null){
            synchronized ("aaa"){
                if (simple==null){
                    simple=new Simple();
                    return simple;
                }
            }
        }
        return simple;
    }
}
