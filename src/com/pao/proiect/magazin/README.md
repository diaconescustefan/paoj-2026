# Sistem de Gestiune Stocuri Magazin - Etapa I

## Descriere Proiect

Acest proiect implementează un sistem de gestiune stocuri pentru un magazin. Sistemul permite gestionarea produselor, categoriilor, furnizorilor, clienților, angajaților și comenzilor. Proiectul este implementat fără JDBC, bază de date sau fișiere SQL - datele sunt stocate în memorie.

## Structură Proiect

```
src/com/pao/proiect/magazin/
├── Main.java                          # Punctul de intrare al aplicației
├── model/                             # Clasele model
│   ├── CodProdus.java                # Clasă imutabilă
│   ├── Produs.java                   # Produs cu equals() și hashCode()
│   ├── Categorie.java                # Categorie de produse
│   ├── Furnizor.java                 # Furnizor
│   ├── Persoana.java                 # Clasă abstractă (bază pentru ierarhie)
│   ├── Angajat.java                  # Angajat (extinde Persoana)
│   ├── Manager.java                  # Manager (extinde Angajat)
│   ├── Client.java                   # Client cu equals() și hashCode()
│   ├── Comanda.java                  # Comandă cu LineComanda
│   └── LinieComanda.java             # Linie din comandă
├── service/                           # Serviciile Singleton
│   ├── ProdusService.java            # Serviciul de gestionare produse
│   └── ComandaService.java           # Serviciul de gestionare comenzi
└── exception/                         # Excepțiile custom
    ├── ProdusNegasitException.java    # Exceție produs negasit
    └── StocInsuficientException.java  # Exceție stoc insuficient
```

## Acțiuni/Interogări Implementate (10 acțiuni)

1. **Adaugă produs** - Adaugă un produs nou în inventarul magazinului
2. **Listează produse** - Afișează toate produsele din sistem
3. **Caută produs după cod** - Găsește un produs specific după codul unic
4. **Șterge produs** - Elimină un produs din inventar
5. **Caută produse după categorie** - Listează toate produsele dintr-o categorie
6. **Actualizează stoc** - Modifică cantitatea disponibilă a unui produs
7. **Adaugă furnizor** - Adaugă un furnizor nou în sistem
8. **Plasează comandă** - Creeaza o comandă cu una sau mai multe linii
9. **Afișează comenzile unui client** - Listează toate comenzile unui client
10. **Afișează produse sortate după preț** - Listează produsele ordonate după preț

## Tipuri de Obiecte din Domeniu (10 tipuri)

1. **Produs** - Entitatea principală reprezentând un articol vândut
2. **Categorie** - Clasificarea produselor (Electronice, Îmbrăcăminte, etc.)
3. **Furnizor** - Compania care furnizează produse
4. **Client** - Persoana care cumpără produse
5. **Comanda** - Reprezentează o comandă plasată de client
6. **LinieComanda** - Detaliile unui produs în cadrul unei comenzi
7. **Persoana** - Clasă abstractă pentru entități cu atribute umane
8. **Angajat** - Persoană care lucrează în magazin
9. **Manager** - Angajat cu responsabilități de management
10. **CodProdus** - Clasă imutabilă pentru identificarea unică a produselor

## Cerințe OOP Implementate

### Encapsulare
- ✓ Toate atributele sunt private sau protected
- ✓ Getteri și setteri unde este necesar
- ✓ Validare inputuri în servicii

### Moștenire (2 niveluri)
- ✓ Ierarhie: `Persoana` → `Angajat` → `Manager`
- ✓ Ierarhie: `Persoana` → `Client`
- ✓ `Persoana` este clasă abstractă cu metoda abstractă `getRol()`

### Polimorfism
- ✓ Metoda abstractă `getRol()` implementată diferit în fiecare subclasă
- ✓ `toString()` supracompus în toate clasele

### Echivalență și Egalitate
- ✓ `equals()` și `hashCode()` suprascriere în `Produs` (pe baza codului)
- ✓ `equals()` și `hashCode()` suprascriere în `Client` (pe baza ID-ului)
- ✓ `equals()` și `hashCode()` suprascriere în `Furnizor` (pe baza ID-ului)

### Imutabilitate
- ✓ `CodProdus` - clasă `final` cu atribute `final`
- ✓ Inițializare completă în constructor
- ✓ Fără setteri pentru `CodProdus`

### Colecții
- ✓ `List<Produs>` - pentru lista tuturor produselor
- ✓ `Map<CodProdus, Produs>` - pentru indexare rapidă pe baza codului
- ✓ `List<Furnizor>` și `List<Comanda>` - pentru stocarea altor entități
- ✓ Sortare cu `Comparator` - `afiseazaProduseSortateDupaPret()`

### Excepții Custom
- ✓ `ProdusNegasitException` - aruncată când produsul nu există
- ✓ `StocInsuficientException` - aruncată când stocul este insuficient
- ✓ Try-catch în `Main.java` pentru tratarea acestor excepții

### Servicii Singleton
- ✓ `ProdusService` - constructor privat, `getInstance()` static
- ✓ `ComandaService` - constructor privat, `getInstance()` static
- ✓ Validare inputuri în ambele servicii
- ✓ Nicio metodă nu returnează null (sau este validat)

## Compilare și Rulare

### Compilare

Din directorul rădăcină al proiectului (`c:\Users\diaco\OneDrive\Desktop\paoj-2026\`):

**Opțiunea 1: Compilare pas cu pas**
```bash
javac -d bin src/com/pao/proiect/magazin/exception/*.java
javac -d bin src/com/pao/proiect/magazin/model/*.java
javac -d bin -cp bin src/com/pao/proiect/magazin/service/*.java
javac -d bin -cp bin src/com/pao/proiect/magazin/Main.java
```

**Opțiunea 2: Compilare într-un singur pas (mai ușor)**
```bash
javac -d bin src\com\pao\proiect\magazin\exception\*.java src\com\pao\proiect\magazin\model\*.java src\com\pao\proiect\magazin\service\*.java src\com\pao\proiect\magazin\Main.java
```

**Windows PowerShell (recomandă folosesc recursiv):**
```powershell
javac -d bin @((Get-ChildItem -Recurse -Filter "*.java" -Path "src\com\pao\proiect\magazin").FullName)
```

### Rulare

```bash
java -cp bin com.pao.proiect.magazin.Main
```

## Output Așteptat

Programul afișează:
1. Inițializarea datelor de test (categorii, furnizori, produse, clienți, angajați)
2. Adăugarea a 5 produse
3. Listarea tuturor produselor
4. Căutarea unui produs după cod (inclusiv excepție pentru inexistent)
5. Căutarea produselor din categoria "Electronice"
6. Actualizarea stocului a 2 produse
7. Adăugarea unui nou furnizor
8. Plasarea a 2 comenzi cu tratarea stocului
9. Afișarea comenzilor unui client cu detalii
10. Ștergerea unui produs
11. Afișarea produselor sortate după preț
12. Informații suplimentare despre comenzi și personal

## Detalii Implementare

### ProdusService (Singleton)
Metode implementate:
- `adaugaProdus(Produs)` - Adaugă produs cu validare
- `stergeProdus(CodProdus)` - Șterge produs cu excepție dacă nu există
- `cautaProdusDupaCod(CodProdus)` - Caută produs cu excepție dacă nu găsit
- `listeazaProduse()` - Returnează lista tuturor produselor
- `cautaProduseDupaCategorie(String)` - Caută produse în categorie
- `actualizeazaStoc(CodProdus, int)` - Actualizează stoc
- `scadeStoc(CodProdus, int)` - Scade stoc (cu validare)
- `afiseazaProduseSortateDupaPret()` - Returnează produse sortate
- `adaugaFurnizor(Furnizor)` - Adaugă furnizor
- `listeazaFurnizori()` - Listează furnizori

### ComandaService (Singleton)
Metode implementate:
- `plaseazaComanda(Client, List<LinieComanda>)` - Plasează comandă
- `listeazaComenzi()` - Listează toate comenzile
- `afiseazaComenziClient(Client)` - Listează comenzile unui client
- `obtineComanda(int)` - Obține comandă după ID

### Clasele Model
- **Produs** - Conține cod, nume, descriere, preț, stoc, categorie, furnizor
- **Client** - Extinde Persoana, adaugă telefon, adresă, număr comenzi
- **Angajat** - Extinde Persoana, adaugă departament, salariu
- **Manager** - Extinde Angajat, adaugă număr subordonate, bonus
- **Comanda** - Conține client, linii, dată, status, total

## Calitate Cod

- ✓ Cod simplu și ușor de urmărit
- ✓ Comentarii la clase și metode importante
- ✓ Fără Scanner - date hardcodate în Main
- ✓ Compilează fără erori
- ✓ Rulează fără excepții netratat
- ✓ Respectă convenții Java (camelCase, etc.)

## Notă
Acest proiect implementează doar Etapa I. Pentru etapele următoare se vor adăuga:
- JDBC și conexiune la bază de date
- Repository pattern
- Fișiere SQL pentru inițializare bază de date
- Interfață grafică posibilă
- Autentificare și autorizare
