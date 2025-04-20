import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List; 

public class RenommerFichiers {

    public static void main(String[] args) {
        Path dossier = Paths.get("dossier");  

        try {
            Files.walkFileTree(dossier, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Fichier : " + file.getFileName());

                    // Lire le contenu du fichier
                    List<String> lignes = Files.readAllLines(file);
                    StringBuilder contenu = new StringBuilder();
                    for (String ligne : lignes) {
                        contenu.append(ligne).append(System.lineSeparator());
                    }

                    // Modifier le contenu
                    String nouveauContenu = contenu.toString().replace("toto", "tutu") + "coucou";

                    // Écrire le nouveau contenu dans le fichier
                    Files.write(file, nouveauContenu.getBytes());

                    System.out.println("Modifié : " + file.getFileName());

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Dossier : " + dir.getFileName());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

