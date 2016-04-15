    package util.generatoriCasuali;

    import java.util.Objects;

    /**
     * Creato da Vlady il 15/04/2016.
     * in origine parte del progetto:
     * CircoloTennis
     */
    public class rdnDate {

        public static String getStandard(char separator) {
            String y = rndYear();
            String m =rndMonth();
            String d = rndDay(m);
            return d + separator + m + separator + y;
        }

        private static String rndDay(String month) {
            //tiene conto di febbraio
            if (month.equals("2")) {
                Integer a = RndNmbrInRange.random(1, 28);
                return a.toString();
            }
            else{
                Integer a = RndNmbrInRange.random(1, 30);
                return a.toString();
            }
        }
        private static String rndMonth() {
            Integer a = RndNmbrInRange.random(1, 12);
            return a.toString();
        }
        private static String rndYear() {
            Integer a = RndNmbrInRange.random(1940, 2010);
            return a.toString();
        }
    }
