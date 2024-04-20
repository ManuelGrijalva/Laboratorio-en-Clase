package edu.ejercicios;

import clases.MongoDBConnection;
import clases.PersonaCRUD;
import com.mongodb.client.MongoDatabase;

public class Main {
    public static void main(String[] args) {
        // Establecer la conexión a MongoDB
        MongoDBConnection dbConnection = new MongoDBConnection("mongodb://localhost:27017", "miBaseDatos");
        MongoDatabase database = dbConnection.getDatabase();

        // Crear instancia de PersonaCRUD para la colección "personas"
        PersonaCRUD personaCRUD = new PersonaCRUD(database, "personas");

        // Insertar una persona
        personaCRUD.insertarPersona("Juan", 30, "Ciudad de México");

        // Mostrar todas las personas
        personaCRUD.mostrarPersonas();

        // Actualizar el nombre de una persona
        personaCRUD.actualizarPersona("Juan", "Juan Pérez");

        // Mostrar todas las personas actualizadas
        personaCRUD.mostrarPersonas();

        // Eliminar una persona
        personaCRUD.eliminarPersona("Juan");

        // Mostrar todas las personas después de eliminar
        personaCRUD.mostrarPersonas();

        // Cerrar la conexión a MongoDB
        dbConnection.close();
    }
}