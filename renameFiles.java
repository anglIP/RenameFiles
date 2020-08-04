import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class renameFiles
{
    // Atributes
    public static final String directoryPath = "C:/Users/Angel/Desktop/Carpetas/Fondos/Fondos 2020/Editados/Fondos/Aleatorios/Prueba/";
    public static final String filePath = "C:/Users/Angel/Desktop/Carpetas/Fondos/Fondos 2020/Editados/Fondos/Aleatorios/Prueba/720Forza.png";

    // Methods
    public static void main(String args[])
    {
        newDate();
        renameFile();
    }


    // El fichero a renombrar a de ser un fichero NUEVO. Si el fichero YA HA SIDO RENOMBRADO, NO SE VA A RENOMBRAR OTRA VEZ.
    public static void renameFile()
    {
        try
        {
            // Open the file.
            File oldFile = new File(filePath);

            // Getting the name and extension of the file.
            String name = oldFile.getName();
            String extension = name.substring(name.lastIndexOf('.'), name.length());

            System.out.println("Nombre del fichero: " + name);
            System.out.println("Extension del fichero: " + extension);

            // Here is the random name creation.
            int random = (int)(Math.random() * 10000);

            String newName = "";

            newName += String.valueOf(random);
            for (int i = 0; i < 2; i++)
			{
				newName += "-";
				random = (int) (Math.random() * 10000);
				newName += String.valueOf(random);
            }
            newName += extension;

            // Open new File with the path and new name
            File newFile = new File(directoryPath + newName);

            System.out.println("Nuevo nombre para el nuevo fichero: " + newFile.getName());

            // Rename the file with the new name generated randomly.
            if (oldFile.renameTo(newFile))
			{
				System.out.println("Nombre cambiado.");
            }
            
            //System.out.println("Nombre del fichero: " + oldFile.getName());
			System.out.println();
			System.out.println();
        } catch (Exception e)
            {
                e.getMessage();
            }
    }

    public static void newDate()
    {
        try
		{
			File oldFile = new File(filePath);

			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

			// Mostramos la última fecha de modificación
			System.out.println("Ultima fecha de modificacion original: " + dateFormat.format(oldFile.lastModified()));

			// Establecemos la nueva fecha para el fichero
			// Intentar obtener la fecha del sistema
			String newLastModifiedString = "07/27/2020";

			// Necesitamos convertir la nueva fecha a milisegundos.
			Date newLastModifiedDate = dateFormat.parse(newLastModifiedString);
			oldFile.setLastModified(newLastModifiedDate.getTime());

			// Mostramos la nueva fecha de modificación
			System.out.println("Nueva ultima fecha de modificacion: " + dateFormat.format(oldFile.lastModified()));
			System.out.println();
		}
		catch (ParseException e)
		{
			e.getMessage();
		}
    }
}