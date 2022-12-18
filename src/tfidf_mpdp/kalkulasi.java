package tfidf_mpdp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class kalkulasi{
        
        //fungsi menghitung total kata
        public int total_kata(String teks){
            String[] kata = teks.split(" ");
            int total = kata.length;
            return total;
        }
        
        //fungsi menghitung minimum threshold
        public double minimum_threshold(int total_kata, int total_kalimat){
            double minimum_threshold = (double) total_kata / total_kalimat;
            return minimum_threshold;
        }
        
        //fungsi menghitung text frequency sebuah kata
        public double text_frequency(int total_kemunculan_kata, int total_kata){
            double text_frequency = (double) total_kemunculan_kata / total_kata;
            return text_frequency;
        }

        //fungsi menghitung inverse document frequency sebuah kata
        public double inverse_document_frequency(int total_kalimat, int total_kemunculan_kata){
            double inverse_document_frequency = (double) total_kalimat / total_kemunculan_kata;
            return inverse_document_frequency;
        }
        
        //fungsi menghitung weight sebuah kata
        public double weight_of_word(double tf, double idf){
            // System.out.println(tf);
            // System.out.println(idf);
            // System.out.println((double)Math.log(idf) / Math.log(2));
            double weight_of_word = (double) tf * (Math.log(idf) / Math.log(2));
            return weight_of_word;
        }
        
        //fungsi menghitung n frequency dari sebuah kalimat
        public double n_frequency(double minimum_threshold, int total_kata_kalimat){
            double maximum;
            if (minimum_threshold > total_kata_kalimat) {
                maximum = minimum_threshold;
            } else {
                maximum = total_kata_kalimat;
            }

            return maximum;
        }
        
        //fungsi menghitung bobot sebuah kalimat
        public double weight_of_sentence(double total_weight_of_words, double n_frequency){
            double weight_of_sentence = total_weight_of_words / n_frequency;
            return weight_of_sentence;
        }

        
}
