public class Config {

    public static final int BOARD = 50;
    public static int nubmerClellr;//в будущем можно будет менять на 3x3, 4x4,5x5,8x8;
    private final static int WHUTEREGION = 20;
    private final static int SIZE = 4;
    public static final int WIDTH = BOARD * SIZE + WHUTEREGION;// + 14;
    public static final int HEIGH = BOARD * SIZE + WHUTEREGION;// + 59;
    public static int number8x8 = 0;


    public static int heigh_width(){
        return BOARD * nubmerClellr + WHUTEREGION + number8x8;
    }
}
