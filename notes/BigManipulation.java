
public class BigManipulation {

   
   public int flipBit(int bit) {
      return bit ^ 1;
   }
   
   public int sign(int a) {
      return flipBit((a >> 31) & 0x1);
   }
}
