public class ApplicationConfiguration {
    private String theme;
    private int fontSize;
    private boolean notificationEnabled;
    private String language;
    public ApplicationConfiguration(String theme, int fontSize, boolean notificationEnabled, String language) {
        this.theme = theme;
        this.fontSize = fontSize;
        this.notificationEnabled = notificationEnabled;
        this.language = language;

    }

    public ConfigurationMemento save(){
        System.out.println("Saving configuration");
        return new ConfigurationMemento(theme,fontSize,notificationEnabled,language);
    }
    public void restore(ConfigurationMemento memento){
        System.out.println("Restoring configuration");
        this.theme = memento.getTheme();
        this.fontSize = memento.getFontSize();
        this.notificationEnabled = memento.isNotificationEnabled();
        this.language = memento.getLanguage();
        System.out.println("Configuration restored");

    }
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public boolean isNotificationEnabled() {
        return notificationEnabled;
    }

    public void setNotificationEnabled(boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "ApplicationConfiguration{" +
                "theme='" + theme + '\'' +
                ", fontSize='" + fontSize + '\'' +
                ", notificationEnabled=" + notificationEnabled +
                ", language='" + language + '\'' +
                '}';
    }
}
