package relvdemoo;

import java.util.List;

import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Author a1 = new Author("Vishnu");
        Author a2 = new Author("Sai");

        Book b1 = new Book("DSA");
        Book b2 = new Book("C");

        // Set relationships
        a1.addBook(b1);
        a2.addBook(b2);

        // Persist objects
        em.persist(a1);
        em.persist(a2);
        em.persist(new User("Bob","adgsdj@gmail.com","pass"));
        em.persist(new User("asif","ddd@gmail.com","fail"));

        em.getTransaction().commit();
List<User>users1=em.createQuery("select u from User u where u.status=:status",User.class)
.setParameter("status","fail").getResultList();
for(User u:users1) {
	System.out.println(u.getStatus());
	System.out.println(u.getName());
	System.out.println(u.getEmail());
}

// Fetch and print book details
//       em.getTransaction().begin();
//        Book fetchedBook = em.find(Book.class, b1.getId());
//        System.out.println("Book: " + fetchedBook.getTitle());
//        System.out.println("Accessing Author...");
//        System.out.println("Author: " + fetchedBook.getAuthor().getName());
//
//        em.getTransaction().commit();
List<User>user2=em.createNamedQuery("User.findAsif",User.class).setParameter("email","ddd@gmail.com").getResultList();
for(User u:user2) {
	System.out.println(u.getName());
}
List<User>user3=em.createNamedQuery("User.findArif",User.class).setParameter(1,"pass").getResultList();
for(User u:user3) {
	System.out.println(u.getName());
}

em.close();
        JPAUtil.close();
    }
}
