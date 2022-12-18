/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfidf_mpdp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Eri
 */
public class hitung {
    String driver, database, user, pass;
    public static double minimum_threshold;
    public static int total_kata;
    public static int total_kalimat;
    public static ArrayList<String> data;
    public static ArrayList<Double> weight_sentence;
    public static ArrayList<Integer> indices;
    
    public static void main(String args[]) {
        
        
        int jumlah = 0;
        weight_sentence = new ArrayList<>();
        data = new ArrayList<>();
        
        //mengambil seluruh teks dari database
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tfidf", "root","");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM kalimat2";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String value = rs.getString("teks");
                data.add(value);
            }
        } catch (SQLException e) {
            System.out.println("Error: unable to fetch data from database!");
        } 
        
//        for (String value : data) {
//             System.out.println(value);
//         }
        
        //menghitung total kata
        kalkulasi klk = new kalkulasi();
        
        for(int i = 0; i < data.size(); i++){
            jumlah = klk.total_kata(data.get(i));
            total_kata = total_kata + jumlah;
        }
//        System.out.println(total_kata);

        //menghitung total kalimat
        total_kalimat = data.size();
//        System.out.println(total_kalimat);
        
        //menghitung minimum threshold
        minimum_threshold = klk.minimum_threshold(total_kata, total_kalimat);
//         System.out.println(minimum_threshold);

        for(int j = 0 ; j < total_kalimat; j++){
            //menghitung frekuensi kemunculan sebuah kata
            String kalimat = data.get(j);
            String[] kumpulan_kata = kalimat.split(" ");
            String kata;
            int total_kemunculan_kata = 0;
            List<Double> weight_kata = new ArrayList<>();
            // System.out.println(kata);

//            System.out.println(kalimat);

            for(int i = 0; i < kumpulan_kata.length; i++){
                kata = kumpulan_kata[i];

                total_kemunculan_kata = 0;
                for (String sentence : data) {
                    String[] words = sentence.split(" ");
                    for (String word : words) {
                    if (word.equals(kata)) {
                        total_kemunculan_kata++;
                    }
                    }
                }
                

                // //menghitung text frequency
                double text_frequency = klk.text_frequency(total_kemunculan_kata, total_kata);
                
            
                // //menghitung inverse document frequency
                double inverse_document_frequency = klk.inverse_document_frequency(total_kalimat, total_kemunculan_kata);

                // //menghitung bobot sebuah kata
                double weight_of_word = klk.weight_of_word(text_frequency, inverse_document_frequency);
                weight_kata.add(weight_of_word);

                // System.out.print(kumpulan_kata[i]);
//                String format = "%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n";
//                System.out.printf(format, kumpulan_kata[i], String.format("tf(%s)", kumpulan_kata[i]), String.format("= %.4f|", text_frequency), String.format("idf(%s)", kumpulan_kata[i]), String.format("= %.1f|", inverse_document_frequency), String.format("W(%s)", kumpulan_kata[i]), String.format("= %.4f|", weight_of_word));
            }

            //menghitung n-frequency
            int total_kata_kalimat = kumpulan_kata.length;
            double n_frequency = klk.n_frequency(minimum_threshold, total_kata_kalimat);
            // System.out.println(n_frequency);

            //menghitung jumlah total dari weight of word
            double total_weight_of_words = 0;
            for(double value : weight_kata){
            total_weight_of_words += value;
            }

            //menghitung weight of sentence
            double weight_of_sentence = klk.weight_of_sentence(total_weight_of_words, n_frequency);
            weight_sentence.add(weight_of_sentence);
            // System.out.println(weight_of_sentence);

//            String format2 = "\n%-10s%-15s";
//            System.out.printf(format2, "nf(s)", String.format("= %.1f", n_frequency));
//            System.out.printf(format2, "Sigma W", String.format("= %.9f", total_weight_of_words));
//            System.out.printf(format2, "W(s)", String.format("= %.9f", weight_of_sentence));
//            System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
            
        }
        //menyimpan index dari kalimat untuk nanti diurutkan
        indices = new ArrayList<>();
        for (int i = 0; i < weight_sentence.size(); i++) {
            indices.add(i);
        }

//        Collections.sort(indices, (i, j) -> -1 * weight_sentence.get(i).compareTo(weight_sentence.get(j)));
//        System.out.println("Urutan Kalimat dari yang memiliki weight terbesar ke terendah:");
//        
//        String format3 = "\n%-4s%-80s%-4s%-15s";
//        for (int i = 0; i < weight_sentence.size(); i++){
//            System.out.printf(format3, String.format("%d.", i+1),data.get(indices.get(i)), "W(s)", String.format("= %.4f", weight_sentence.get(indices.get(i))));
//        }
            
        
    }
    public static int getTotalKata() {
        return total_kata;
    }
    
    public static int getTotalKalimat() {
        return total_kalimat;
    }
    
    public static double getMinimumThreshold() {
        return minimum_threshold;
    }
    
    public ArrayList<String> getTexts() {
        return data;
    }
    
    public ArrayList<Double> getWeight() {
        return weight_sentence;
    }
    
    public ArrayList<Integer> getIndices(){
        return indices;
    }
    
   
}
