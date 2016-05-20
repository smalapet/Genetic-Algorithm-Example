/*
* @author 	Sivarat Malapet
* @Copyrights 	Sivarat Malapet 2014
*/

public class Main {

    public static void main(String[] args) {
        int BestFitnessIndex = 0;
        int chrom_size = 1000;
//      int gene_size = 20;
//      int StopCondition = 2;
//      int gene_size = 30;
//      int StopCondition = 2;
//      int gene_size = 40;
//      int StopCondition = 5;
        int gene_size = 20;
        int StopCondition = 2;
        int count = 1;
        String BestFitnessChromosomeData = "";
        GA GA = new GA();
        GA.Prt("===============================================");
        GA.Prt("================ Start Java GA ================");
        GA.Prt("===============================================");
        GA.Prt("********** 1. Initialized Chomosomes[10][100]");
        GA.InitializedChomosomes(chrom_size, gene_size);
        GA.Prt("********** 2. Initialized Target");
        GA.InitializedTarget(gene_size);
        GA.Prt("********** Start Learning **********");
        while(GA.GetFitnessChromosomeValue() > StopCondition){
            GA.Prt("********** Generation " + count);
            //GA.Prt("********** 3. Search Best Fitness");
            BestFitnessIndex = GA.SearchBestFitness(gene_size);
            //GA.Prt("********** Best Fitness Index = " + Integer.toString(BestFitnessIndex + 1));
            BestFitnessChromosomeData = GA.GetFitnessChromosomeData(BestFitnessIndex);
            //GA.Prt(GA.GetTargetData());
            GA.Prt(BestFitnessChromosomeData);
            GA.Prt("********** Score: " + Integer.toString(GA.GetFitnessChromosomeValue()));
            GA.Prt("********** Cross Over **********");
            GA.CrossOver(BestFitnessChromosomeData, gene_size, gene_size-4);
            //GA.Prt("********** Mutation **********");
            GA.Mutation(gene_size);
            count++;
        }
    }
}
