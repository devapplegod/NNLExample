import java.util.Scanner;

public class NNLExample {

    public static void main(String[] args){

        // Zavedené hodnoty do proměnných, hodnoty by ale mohly rovnou být vloženy jako argumenty bez vytváření proměnných
        int inputNodes = 1;
        int outputNodes = 1;
        int hiddenNodes = 10;
        int dataSize = 30;

        Array2D trainInputData = new Array2D(dataSize, inputNodes).random().multiply(1);
        Array2D trainOutputData = trainInputData.multiply(10); // Tím .multiply(10) se vynásobí všechny hodnoty v trainInputData deseti a tudíž se síť naučí také násobit deseti.

        // Vytvoření objektu sítě pomocí počtu inputů, outputů, skrytých nodů a learning ratu (o kolik se upraví weights s každou iterací učení)
        NeuralNetwork neuralNetwork = new NeuralNetwork(inputNodes, outputNodes, hiddenNodes, 0.001F);

        // Započatí učení s inputy, k nim přirazenými outputy, počtem iterací učení a booleanem zda printovat "chybovost" sítě
        neuralNetwork.train(trainInputData, trainOutputData, 1000, true);

        System.out.println("Training finished in " + neuralNetwork.getLastTrainTime() + " seconds");

        // Celkem tedy na vytvoření a naučení neuronové sítě byly použity pouhé 4 potřebné řádky kódu.

        while (true){
            // Vezme input od uživatele a převede ho do Array2D objektu (z mojí knihovny), protože síť potřebuje inputy v tomto tvaru. Potom udělá predikci a vytiskne ji.
            Scanner scanner = new Scanner(System.in);
            System.out.println("Vyberte input číslo: ");
            float n = scanner.nextFloat();
            Array2D inputs = new Array2D(1, 1).random();
            inputs.setValue(0, 0, n);
            float result = neuralNetwork.predict(inputs).getValue(0, 0);
            System.out.println("Output sítě: " + result);
        }

    }

}
