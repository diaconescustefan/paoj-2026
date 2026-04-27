package com.pao.proiect.magazin;

import com.pao.proiect.magazin.exception.ProdusNegasitException;
import com.pao.proiect.magazin.exception.StocInsuficientException;
import com.pao.proiect.magazin.model.Angajat;
import com.pao.proiect.magazin.model.Categorie;
import com.pao.proiect.magazin.model.Client;
import com.pao.proiect.magazin.model.CodProdus;
import com.pao.proiect.magazin.model.Comanda;
import com.pao.proiect.magazin.model.Furnizor;
import com.pao.proiect.magazin.model.LinieComanda;
import com.pao.proiect.magazin.model.Manager;
import com.pao.proiect.magazin.model.Produs;
import com.pao.proiect.magazin.service.ComandaService;
import com.pao.proiect.magazin.service.ProdusService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Clasa Main care rulează aplicația interactivă pentru sistemul de gestiune stocuri.
 */
public class Main {

    private static final ProdusService produsService = ProdusService.getInstance();
    private static final ComandaService comandaService = ComandaService.getInstance();

    private static final List<Categorie> categorii = new ArrayList<>();
    private static final List<Client> clienti = new ArrayList<>();
    private static final List<Angajat> angajati = new ArrayList<>();

    public static void main(String[] args) {
        initializeazaDate();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("====== SISTEM DE GESTIUNE STOCURI MAGAZIN ======");

        while (running) {
            afiseazaMeniu();
            System.out.print("Optiune: ");
            String optiune = scanner.nextLine().trim();

            try {
                switch (optiune) {
                    case "1":
                        adaugaProdusInteractive(scanner);
                        break;
                    case "2":
                        listeazaProduse();
                        break;
                    case "3":
                        cautaProdusDupaCodInteractive(scanner);
                        break;
                    case "4":
                        stergeProdusInteractive(scanner);
                        break;
                    case "5":
                        cautaProduseDupaCategorieInteractive(scanner);
                        break;
                    case "6":
                        actualizeazaStocInteractive(scanner);
                        break;
                    case "7":
                        adaugaFurnizorInteractive(scanner);
                        break;
                    case "8":
                        plaseazaComandaInteractive(scanner);
                        break;
                    case "9":
                        afiseazaComenziClientInteractive(scanner);
                        break;
                    case "10":
                        afiseazaProduseSortate();
                        break;
                    case "0":
                        running = false;
                        System.out.println("La revedere!");
                        break;
                    default:
                        System.out.println("Optiune invalida. Incearca din nou.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Eroare: introdu un numar valid.");
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println("Eroare: " + e.getMessage());
            } catch (ProdusNegasitException | StocInsuficientException e) {
                System.out.println("Eroare: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void initializeazaDate() {
        if (!categorii.isEmpty()) {
            return;
        }

        Categorie electronice = new Categorie(1, "Electronice");
        Categorie imbracaminte = new Categorie(2, "Imbracaminte");
        Categorie alimente = new Categorie(3, "Alimente");

        categorii.add(electronice);
        categorii.add(imbracaminte);
        categorii.add(alimente);

        Furnizor furnizor1 = new Furnizor(1, "TechSupply", "0721123456", "tech@supply.ro");
        Furnizor furnizor2 = new Furnizor(2, "FoodMart", "0721654321", "food@mart.ro");
        produsService.adaugaFurnizor(furnizor1);
        produsService.adaugaFurnizor(furnizor2);

        produsService.adaugaProdus(new Produs(new CodProdus("LAPTOP001"), "Laptop ASUS",
                "Laptop 15 inch, Intel i7", 3500.0, 10, electronice, furnizor1));
        produsService.adaugaProdus(new Produs(new CodProdus("MOUSE001"), "Mouse Logitech",
                "Mouse wireless", 150.0, 50, electronice, furnizor1));
        produsService.adaugaProdus(new Produs(new CodProdus("TRICOU001"), "Tricou bumbac",
                "Tricou alb 100% bumbac", 35.0, 100, imbracaminte, furnizor2));
        produsService.adaugaProdus(new Produs(new CodProdus("OREZ001"), "Orez Jasmine",
                "Orez premium Thai", 25.0, 200, alimente, furnizor2));

        clienti.add(new Client(1, "Popescu", "Ion", "ion.popescu@email.com",
                "0721234567", "Bucuresti, Str. Principala 10"));
        clienti.add(new Client(2, "Ionescu", "Maria", "maria.ionescu@email.com",
                "0722234567", "Cluj-Napoca, Str. Universitatii 5"));

        angajati.add(new Angajat(1, "Marinescu", "Andrei", "andrei.marinescu@email.com",
                "Vanzari", 2500.0));
        angajati.add(new Manager(2, "Gheorghe", "Cristian", "cristian.gheorghe@email.com",
                "Management", 4000.0, 5, 1000.0));
    }

    private static void afiseazaMeniu() {
        System.out.println();
        System.out.println("1. Adauga produs");
        System.out.println("2. Listeaza produse");
        System.out.println("3. Cauta produs dupa cod");
        System.out.println("4. Sterge produs");
        System.out.println("5. Cauta produse dupa categorie");
        System.out.println("6. Actualizeaza stoc");
        System.out.println("7. Adauga furnizor");
        System.out.println("8. Plaseaza comanda");
        System.out.println("9. Afiseaza comenzile unui client");
        System.out.println("10. Afiseaza produse sortate dupa pret");
        System.out.println("0. Iesire");
    }

    private static void adaugaProdusInteractive(Scanner scanner) {
        System.out.print("Cod produs: ");
        CodProdus cod = new CodProdus(scanner.nextLine().trim());

        System.out.print("Nume produs: ");
        String nume = scanner.nextLine().trim();

        System.out.print("Descriere: ");
        String descriere = scanner.nextLine().trim();

        System.out.print("Pret: ");
        double pret = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Stoc initial: ");
        int stoc = Integer.parseInt(scanner.nextLine().trim());

        afiseazaCategorii();
        System.out.print("ID categorie: ");
        int categorieId = Integer.parseInt(scanner.nextLine().trim());
        Categorie categorie = gasesteCategorieDupaId(categorieId);

        afiseazaFurnizori();
        System.out.print("ID furnizor: ");
        int furnizorId = Integer.parseInt(scanner.nextLine().trim());
        Furnizor furnizor = gasesteFurnizorDupaId(furnizorId);

        Produs produs = new Produs(cod, nume, descriere, pret, stoc, categorie, furnizor);
        produsService.adaugaProdus(produs);
    }

    private static void listeazaProduse() {
        System.out.println("=== Lista produse ===");
        afiseazaListaProduse(produsService.listeazaProduse());
    }

    private static void cautaProdusDupaCodInteractive(Scanner scanner) throws ProdusNegasitException {
        System.out.print("Cod produs cautat: ");
        CodProdus cod = new CodProdus(scanner.nextLine().trim());
        Produs produs = produsService.cautaProdusDupaCod(cod);
        System.out.println("Produs gasit:");
        afiseazaListaProduse(Collections.singletonList(produs));
    }

    private static void stergeProdusInteractive(Scanner scanner) throws ProdusNegasitException {
        System.out.print("Cod produs de sters: ");
        CodProdus cod = new CodProdus(scanner.nextLine().trim());
        produsService.stergeProdus(cod);
    }

    private static void cautaProduseDupaCategorieInteractive(Scanner scanner) {
        afiseazaCategorii();
        System.out.print("Nume categorie: ");
        String categorie = scanner.nextLine().trim();
        List<Produs> produse = produsService.cautaProduseDupaCategorie(categorie);
        System.out.println("=== Produse din categoria " + categorie + " ===");
        afiseazaListaProduse(produse);
    }

    private static void actualizeazaStocInteractive(Scanner scanner) throws ProdusNegasitException {
        System.out.print("Cod produs: ");
        CodProdus cod = new CodProdus(scanner.nextLine().trim());
        System.out.print("Stoc nou: ");
        int stocNou = Integer.parseInt(scanner.nextLine().trim());
        produsService.actualizeazaStoc(cod, stocNou);
    }

    private static void adaugaFurnizorInteractive(Scanner scanner) {
        int idNou = produsService.listeazaFurnizori().size() + 1;
        System.out.print("Nume furnizor: ");
        String nume = scanner.nextLine().trim();
        System.out.print("Telefon: ");
        String telefon = scanner.nextLine().trim();
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();

        Furnizor furnizor = new Furnizor(idNou, nume, telefon, email);
        produsService.adaugaFurnizor(furnizor);
    }

    private static void plaseazaComandaInteractive(Scanner scanner)
            throws ProdusNegasitException, StocInsuficientException {
        afiseazaClienti();
        System.out.print("ID client: ");
        int clientId = Integer.parseInt(scanner.nextLine().trim());
        Client client = gasesteClientDupaId(clientId);

        System.out.print("Numar linii comanda: ");
        int numarLinii = Integer.parseInt(scanner.nextLine().trim());
        if (numarLinii <= 0) {
            throw new IllegalArgumentException("Comanda trebuie sa aiba cel putin o linie.");
        }

        List<LinieComanda> linii = new ArrayList<>();
        Map<CodProdus, Integer> cantitatiTotale = new HashMap<>();
        for (int i = 1; i <= numarLinii; i++) {
            System.out.println("Linia " + i + ":");
            System.out.print("  Cod produs: ");
            CodProdus cod = new CodProdus(scanner.nextLine().trim());
            Produs produs = produsService.cautaProdusDupaCod(cod);

            System.out.print("  Cantitate: ");
            int cantitate = Integer.parseInt(scanner.nextLine().trim());
            if (cantitate <= 0) {
                throw new IllegalArgumentException("Cantitatea trebuie sa fie pozitiva.");
            }

            linii.add(new LinieComanda(produs, cantitate));
            cantitatiTotale.put(cod, cantitatiTotale.getOrDefault(cod, 0) + cantitate);
        }

        for (Map.Entry<CodProdus, Integer> entry : cantitatiTotale.entrySet()) {
            Produs produs = produsService.cautaProdusDupaCod(entry.getKey());
            if (produs.getStoc() < entry.getValue()) {
                throw new StocInsuficientException("Stoc insuficient pentru " + produs.getNume()
                        + ". Stoc disponibil: " + produs.getStoc()
                        + ", cantitate ceruta: " + entry.getValue());
            }
        }

        for (LinieComanda linie : linii) {
            produsService.scadeStoc(linie.getProdus().getCod(), linie.getCantitate());
        }
        comandaService.plaseazaComanda(client, linii);
    }

    private static void afiseazaComenziClientInteractive(Scanner scanner) {
        afiseazaClienti();
        System.out.print("ID client: ");
        int clientId = Integer.parseInt(scanner.nextLine().trim());
        Client client = gasesteClientDupaId(clientId);

        List<Comanda> comenzi = comandaService.afiseazaComenziClient(client);
        if (comenzi.isEmpty()) {
            System.out.println("Clientul nu are comenzi inregistrate.");
            return;
        }

        System.out.println("=== Comenzi client " + client.getNume() + " " + client.getPrenume() + " ===");
        for (Comanda comanda : comenzi) {
            afiseazaDetaliiComanda(comanda);
        }
    }

    private static void afiseazaProduseSortate() {
        System.out.println("=== Produse sortate dupa pret ===");
        afiseazaListaProduseCuPret(produsService.afiseazaProduseSortateDupaPret());
    }

    private static void afiseazaCategorii() {
        System.out.println("Categorii disponibile:");
        for (Categorie categorie : categorii) {
            System.out.println("  " + categorie.getId() + ". " + categorie.getNume());
        }
    }

    private static void afiseazaFurnizori() {
        System.out.println("Furnizori disponibili:");
        for (Furnizor furnizor : produsService.listeazaFurnizori()) {
            System.out.println("  " + furnizor.getId() + ". " + furnizor.getNume());
        }
    }

    private static void afiseazaClienti() {
        System.out.println("Clienti disponibili:");
        for (Client client : clienti) {
            System.out.println("  " + client.getId() + ". " + client.getNume() + " " + client.getPrenume());
        }
    }

    private static Categorie gasesteCategorieDupaId(int id) {
        for (Categorie categorie : categorii) {
            if (categorie.getId() == id) {
                return categorie;
            }
        }
        throw new IllegalArgumentException("Nu exista categorie cu ID-ul " + id + ".");
    }

    private static Furnizor gasesteFurnizorDupaId(int id) {
        for (Furnizor furnizor : produsService.listeazaFurnizori()) {
            if (furnizor.getId() == id) {
                return furnizor;
            }
        }
        throw new IllegalArgumentException("Nu exista furnizor cu ID-ul " + id + ".");
    }

    private static Client gasesteClientDupaId(int id) {
        for (Client client : clienti) {
            if (client.getId() == id) {
                return client;
            }
        }
        throw new IllegalArgumentException("Nu exista client cu ID-ul " + id + ".");
    }

    private static void afiseazaListaProduse(List<Produs> produse) {
        if (produse.isEmpty()) {
            System.out.println("Nu sunt produse in sistem.");
            return;
        }
        for (Produs produs : produse) {
            System.out.println("- " + produs.getNume() + " [" + produs.getCod().getCod() + "]");
            System.out.println("  Descriere: " + produs.getDescriere());
            System.out.println("  Categorie: " + produs.getCategorie().getNume());
            System.out.println("  Furnizor: " + produs.getFurnizor().getNume());
            System.out.println("  Pret: " + produs.getPret() + " lei | Stoc: " + produs.getStoc());
        }
    }

    private static void afiseazaListaProduseCuPret(List<Produs> produse) {
        if (produse.isEmpty()) {
            System.out.println("Nu sunt produse in sistem.");
            return;
        }
        for (Produs produs : produse) {
            System.out.println("- " + produs.getNume() + " -> " + produs.getPret()
                    + " lei (stoc: " + produs.getStoc() + ")");
        }
    }

    private static void afiseazaDetaliiComanda(Comanda comanda) {
        System.out.println("Comanda #" + comanda.getId() + " | Status: " + comanda.getStatus()
                + " | Total: " + comanda.getTotalComanda() + " lei");
        for (LinieComanda linie : comanda.getLinii()) {
            System.out.println("  - " + linie.getProdus().getNume() + " x" + linie.getCantitate()
                    + " @ " + linie.getPretUnitar() + " = " + linie.getSubtotal() + " lei");
        }
    }
}
