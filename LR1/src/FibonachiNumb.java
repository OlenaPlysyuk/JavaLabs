public class FibonachiNumb {
    public FibonachiNumb() {

    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setValue(long value) {
        this.value = value;
    }

    private int number;
        private long value;

        public FibonachiNumb(int number, long value){
            this.number=number;
            this.value=value;
        }
        public int getNumber(){
            return number;
        }
        public long getValue(){
            return value;
        }

}
