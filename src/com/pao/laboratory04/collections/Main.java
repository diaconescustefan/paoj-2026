package com.pao.laboratory04.collections;

/**
 * Exercițiul 1 — Colecții: HashMap și TreeMap
 *
 * Creează în acest main:
 *
 * PARTEA A — HashMap (frecvența cuvintelor)
 * 1. Declară un array de String-uri:
 *    String[] words = {"java", "python", "java", "c++", "python", "java", "rust", "c++", "go"};
 * 2. Creează un HashMap<String, Integer> care contorizează de câte ori apare fiecare cuvânt.
 *    - Parcurge array-ul și folosește put() + getOrDefault() pentru a incrementa contorul.
 * 3. Afișează map-ul.
 * 4. Verifică dacă există cheia "rust" cu containsKey().
 * 5. Afișează DOAR cheile (keySet()), apoi DOAR valorile (values()).
 * 6. Parcurge map-ul cu entrySet() și afișează "cheia -> valoarea" pentru fiecare intrare.
 *
 * PARTEA B — TreeMap (sortare automată)
 * 7. Creează un TreeMap<String, Integer> din același HashMap (constructor cu argument).
 * 8. Afișează TreeMap-ul — observă ordinea alfabetică a cheilor.
 * 9. Folosește firstKey() și lastKey() pentru a afișa prima și ultima cheie.
 *
 * PARTEA C — Map cu obiecte
 * 10. Creează un HashMap<String, List<String>> care asociază materii cu liste de studenți.
 *     Exemplu: "PAOJ" -> ["Ana", "Mihai", "Ion"], "BD" -> ["Ana", "Elena"]
 * 11. Afișează toți studenții de la materia "PAOJ".
 * 12. Adaugă un student nou la "BD" și afișează lista actualizată.
 *
 * Output așteptat (orientativ — ordinea HashMap poate varia):
 *
 * === PARTEA A: HashMap — frecvența cuvintelor ===
 * Frecvență: {python=2, c++=2, java=3, rust=1, go=1}
 * Conține 'rust'? true
 * Chei: [python, c++, java, rust, go]
 * Valori: [2, 2, 3, 1, 1]
 * python -> 2
 * c++ -> 2
 * java -> 3
 * rust -> 1
 * go -> 1
 *
 * === PARTEA B: TreeMap — sortare automată ===
 * Sortat: {c++=2, go=1, java=3, python=2, rust=1}
 * Prima cheie: c++
 * Ultima cheie: rust
 *
 * === PARTEA C: Map cu obiecte ===
 * Studenți la PAOJ: [Ana, Mihai, Ion]
 * Studenți la BD (actualizat): [Ana, Elena, George]
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // ========== PARTEA A: HashMap — frecvența cuvintelor ==========
        System.out.println("=== PARTEA A: HashMap — frecvența cuvintelor ===");
        
        String[] words = {"java", "python", "java", "c++", "python", "java", "rust", "c++", "go"};
        Map<String, Integer> frequency = new HashMap<>();
        
        // Contorizează cuvintele folosind put() și getOrDefault()
        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        
        System.out.println("Frecvență: " + frequency);
        
        // Verifică dacă există cheia "rust"
        System.out.println("Conține 'rust'? " + frequency.containsKey("rust"));
        
        // Afișează DOAR cheile
        System.out.println("Chei: " + frequency.keySet());
        
        // Afișează DOAR valorile
        System.out.println("Valori: " + frequency.values());
        
        // Parcurge cu entrySet()
        System.out.println("Perechi cheie-valoare:");
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        // ========== PARTEA B: TreeMap — sortare automată ==========
        System.out.println("\n=== PARTEA B: TreeMap — sortare automată ===");
        
        Map<String, Integer> sorted = new TreeMap<>(frequency);
        System.out.println("Sortat: " + sorted);
        
        TreeMap<String, Integer> treeMap = new TreeMap<>(frequency);
        System.out.println("Prima cheie: " + treeMap.firstKey());
        System.out.println("Ultima cheie: " + treeMap.lastKey());
        
        // ========== PARTEA C: Map cu obiecte ==========
        System.out.println("\n=== PARTEA C: Map cu obiecte ===");
        
        Map<String, List<String>> subjectsToStudents = new HashMap<>();
        
        // Inițializează listele
        subjectsToStudents.put("PAOJ", new ArrayList<>(Arrays.asList("Ana", "Mihai", "Ion")));
        subjectsToStudents.put("BD", new ArrayList<>(Arrays.asList("Ana", "Elena")));
        subjectsToStudents.put("SO", new ArrayList<>(Arrays.asList("Mihai", "George")));
        
        // Afișează studenții la PAOJ
        System.out.println("Studenți la PAOJ: " + subjectsToStudents.get("PAOJ"));
        
        // Adaugă student nou la BD
        subjectsToStudents.get("BD").add("George");
        System.out.println("Studenți la BD (actualizat): " + subjectsToStudents.get("BD"));
    }
}

