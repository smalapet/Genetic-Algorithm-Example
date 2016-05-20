/*
* @author 	Sivarat Malapet
* @Copyrights 	Sivarat Malapet 2014
*/

import java.util.Random;

public class GA {

    private String[] Chromosomes;
    private String[] Target;
    private String TargetData;
    public int ChromSize;
    public int GeneSize;
    public int FitnessValue;

    public GA(){
        FitnessValue = 100000;
    }
    
    public void Prt(String str){
        System.out.println(str);
    }
    
    //Create an initial population of chromosomes
    public void InitializedChomosomes(int chrom_size, int gene_size){
    	this.ChromSize = chrom_size;
    	this.GeneSize = gene_size;
        Chromosomes = new String[chrom_size];
        Random ran = new Random();
        int val = 0;
        for(int i = 0;i < chrom_size; i++){
            String tmp = "";
            for(int j = 0;j < gene_size; j++){
                val = ran.nextInt(2);            
                tmp += Integer.toString(val);
            }
            Chromosomes[i] = tmp;
            System.out.println(Chromosomes[i]);
        }
    }
    
    //Set Target
    public void InitializedTarget(int gene_size){
        Target = new String[gene_size];
        Random ran = new Random();
        int val = 0;
        String tmp = "";        
        for(int i = 0;i < gene_size;i++){
            val = ran.nextInt(2);
            Target[i] = Integer.toString(val);
            tmp += Target[i];
        }
        TargetData = tmp;
        System.out.println(tmp);
    }
    
    //Search For Best Fitness among chromosomes population
    public int SearchBestFitness(int _minerrsum){
        int FitnessChromosomeIndex;
        int minerrsum = _minerrsum;
        FitnessChromosomeIndex = 0;
        for(int i = 0;i < ChromSize;i++){
            int tmperrsum = _minerrsum;
            String tmp = "";
            for(int j = 0;j < GeneSize;j++){
                if(Chromosomes[i].substring(j, j+1).equals(Target[j])){
                    tmperrsum--;
                }
            }
            tmp = Chromosomes[i];
            //System.out.println(tmp + " (" + Integer.toString(tmperrsum) + ")");
            if(minerrsum > tmperrsum){minerrsum = tmperrsum; FitnessChromosomeIndex = i; FitnessValue = minerrsum;}
        }
        return FitnessChromosomeIndex;
    }
    
    //Get Fitness Chromosome Value
    public int GetFitnessChromosomeValue(){
        return FitnessValue;
    }
    
    //Get Fitness Chromosome Data
    public String GetFitnessChromosomeData(int index){
        String ret = "";
        ret = Chromosomes[index];
        return ret;
    }

    //Get Target Data
    public String GetTargetData(){
        return TargetData;
    }

    //Make Cross Over
    public void CrossOver(String chrom, int gene_size, int divider){
        String part1 = chrom.substring(0, divider+1);
        for(int i = 0;i < ChromSize;i++){
            String part2 = Chromosomes[i].substring(divider+1, chrom.length());
            Chromosomes[i] = part2 + part1;
            //System.out.println(Chromosomes[i]);
        }
    }

    //Make Mutation
    public void Mutation(int gene_size){
        for(int i = 0;i < ChromSize;i++){
            String tmp = "";
            String part1 = "";
            String part2 = "";
            Random ran = new Random();
            int pos1 = ran.nextInt(gene_size);
            int pos2 = ran.nextInt(gene_size);
            int pos3 = ran.nextInt(gene_size);
            tmp = Chromosomes[i].substring(pos1, pos1+1);
            if(tmp.equals("0")){tmp = "1";}else{tmp = "0";}
            part1 = Chromosomes[i].substring(0, pos1);
            part2 = Chromosomes[i].substring(pos1+1,Chromosomes[i].length());
            Chromosomes[i] = part1 + tmp + part2;
            tmp = Chromosomes[i].substring(pos2, pos2+1);
            if(tmp.equals("0")){tmp = "1";}else{tmp = "0";}
            part1 = Chromosomes[i].substring(0, pos2);
            part2 = Chromosomes[i].substring(pos2+1,Chromosomes[i].length());
            Chromosomes[i] = part1 + tmp + part2;
            //System.out.println(Chromosomes[i]);
        }
    }
    
}
