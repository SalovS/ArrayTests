import java.util.Random;

public class Lessons {
    public void Start(){
        lesson1();
        lesson2();
        additionalLesson();
    }

    public void lesson1() {
        String[] words = new String[]{"Каждый", "охотник", "желает", "знать,", "где", "сидит", "фазан."};
        printArray(words);
        String word;
        for (int i = 0; i < words.length / 2; i++) {
            word = words[i];
            words[i] = words[words.length - 1 - i];
            words[words.length - 1 - i] = word;
        }
        printArray(words);
    }

    private void printArray(String[] arr){
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public void lesson2(){
        final int NUM_PATIENTS = 30;
        final float MIN_TEMP = 32;
        final float MAX_TEMP = 40;
        float[] temperature = getTemperature(NUM_PATIENTS, MIN_TEMP, MAX_TEMP);
        printTemperature(temperature);
        System.out.printf("\nСредняя температура: %.2f\n",getAverageTemperature(temperature));
        System.out.printf("Количество здоровых: %d\n",getNumerOfHealthy(temperature));
    }

    private float[] getTemperature(int numb, float minT, float maxT){
        float[] temperature = new float[numb];
        Random random = new Random();
        for(int i = 0; i < numb; i++){
            temperature[i] = minT + (maxT - minT) * random.nextFloat();
        }
        return temperature;
    }

    private float getAverageTemperature(float[] temperature){
        double sumTemperature = 0;
        for(int i = 0; i < temperature.length; i++){
            sumTemperature += temperature[i];
        }
        return (float)(sumTemperature / temperature.length);
    }

    private int getNumerOfHealthy(float[] temperature){
        int healthyPeople = 0;
        for(int i = 0; i < temperature.length; i++){
            if(temperature[i] > 36.5 && temperature[i] < 36.7)
                healthyPeople ++;
        }
        return healthyPeople;
    }

    private void printTemperature(float[] temperature){
        System.out.println("Температуры пациентов: ");
        for(int i = 0; i < temperature.length; i++){
            System.out.printf("%.1f ", temperature[i]);
        }
    }

    public void additionalLesson() {
        final int side = 7;
        String[][] figur = new String[side][side];
        for(int i = 0; i < side; i++){
            for(int j = 0; j < side; j++){
                if(i == j || i == side - 1 - j) {
                    figur[i][j] = "X";
                }
                else {
                    figur[i][j] = " ";
                }
            }
        }
        for(int i = 0; i < side; i++){
            printArray(figur[i]);
        }
    }
}
