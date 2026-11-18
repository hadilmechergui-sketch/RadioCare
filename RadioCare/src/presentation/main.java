package presentation;

import java.time.LocalDate;
import java.util.Scanner;

import controlleur.ExamenMedicalController;
import controlleur.PatientController;
import entity.ExamenMedical;
import entity.Patient;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // On "embauche" nos deux contrôleurs
        PatientController patientController = new PatientController();
        ExamenMedicalController examenController = new ExamenMedicalController();
        
        int choixPrincipal = -1;

        System.out.println("=== BIENVENUE DANS RADIO-CARE ===");

        while (choixPrincipal != 0) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Gestion des Patients");
            System.out.println("2. Gestion des Examens Medicaux");
            System.out.println("0. Quitter l'application");
            System.out.print("Votre choix : ");
            
            choixPrincipal = scanner.nextInt();
            scanner.nextLine(); // Nettoyage de la touche Entrée

            try {
                if (choixPrincipal == 1) {
                    menuPatient(scanner, patientController);
                } else if (choixPrincipal == 2) {
                    menuExamen(scanner, examenController);
                } else if (choixPrincipal == 0) {
                    System.out.println("Fermeture de l'application. Au revoir !");
                } else {
                    System.out.println("Choix invalide.");
                }
            } catch (IllegalArgumentException e) {
                // C'est ici qu'on attrape les erreurs de règles métier (ex: tarif négatif)
                System.out.println("\n❌ ERREUR METIER : " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\n❌ ERREUR SYSTEME : " + e.getMessage());
            }
        }
        
        scanner.close();
    }

    private static void menuPatient(Scanner scanner, PatientController controller) {
        System.out.println("\n--- MENU PATIENTS ---");
        System.out.println("1. Ajouter un patient");
        System.out.println("2. Lister tous les patients");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        if (choix == 1) {
            System.out.print("CIN/Matricule : ");
            String cin = scanner.nextLine();
            System.out.print("Nom : ");
            String nom = scanner.nextLine();
            System.out.print("Prenom : ");
            String prenom = scanner.nextLine();
            System.out.print("Telephone : ");
            String tel = scanner.nextLine();
            System.out.print("Numero d'assurance : ");
            String numAssurance = scanner.nextLine();
            
            Patient nouveau = new Patient(cin, nom, prenom, LocalDate.now(), tel, null, numAssurance, 0.0, null);
            controller.ajouterPatient(nouveau);
            System.out.println("✅ Patient ajoute avec succes !");
            
        } else if (choix == 2) {
            System.out.println("--- LISTE DES PATIENTS ---");
            for (Patient p : controller.listerPatients()) {
                System.out.println("- " + p.getCinMatricule() + " | " + p.getNom());
            }
        }
    }

    private static void menuExamen(Scanner scanner, ExamenMedicalController controller) {
        System.out.println("\n--- MENU EXAMENS MEDICAUX ---");
        System.out.println("1. Ajouter un examen");
        System.out.println("2. Lister tous les examens");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        if (choix == 1) {
            System.out.print("ID de l'examen (ex: EX-001) : ");
            String id = scanner.nextLine();
            System.out.print("Code Acte (ex: ACT-IRM) : ");
            String code = scanner.nextLine();
            System.out.print("Libelle (ex: IRM Cerebrale) : ");
            String libelle = scanner.nextLine();
            System.out.print("Duree estimee (en minutes) : ");
            int duree = scanner.nextInt();
            System.out.print("Tarif HT : ");
            double tarif = scanner.nextDouble();
            scanner.nextLine();
            
            ExamenMedical nouvelExamen = new ExamenMedical(id, code, libelle, duree, tarif);
            controller.ajouterExamen(nouvelExamen);
            System.out.println("✅ Examen ajoute avec succes !");
            
        } else if (choix == 2) {
            System.out.println("--- LISTE DES EXAMENS ---");
            for (ExamenMedical e : controller.listerExamens()) {
                System.out.println(e.toString());
            }
        }
    }
}