package io.loop.pages;

public class POM {

    private LoginPage loginPage;
    private GoogleSearchPage googleSearchPage;
    private ProductPage productPage;
    private LeftNavigatePage leftNavigatePage;
    private ClientsPage clientsPage;
    private UserPage usersPage;
    private HomePage homePage;

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public UserPage getUsersPage() {
        if (usersPage == null) {
            usersPage = new UserPage();
        }
        return usersPage;
    }

    public ClientsPage getClientsPage() {
        if (clientsPage == null) {
            clientsPage = new ClientsPage();
        }
        return clientsPage;
    }

    public LeftNavigatePage getLeftNavigatePage() {
        if (leftNavigatePage == null) {
            leftNavigatePage = new LeftNavigatePage();
        }
        return leftNavigatePage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public GoogleSearchPage getGoogleSearchPage() {
        if (googleSearchPage == null) {
            googleSearchPage = new GoogleSearchPage();
        }
        return googleSearchPage;
    }

    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }

}
