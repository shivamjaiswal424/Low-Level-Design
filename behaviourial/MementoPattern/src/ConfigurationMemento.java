public class ConfigurationMemento {
    private final String theme;
    private final int fontSize;
    private final boolean notificationEnabled;
    private final String language;

    public ConfigurationMemento(String theme, int fontSize, boolean notificationEnabled, String language) {
        this.theme = theme;
        this.fontSize = fontSize;
        this.notificationEnabled = notificationEnabled;
        this.language = language;
    }

    public String getTheme() {
        return theme;
    }

    public int getFontSize() {
        return fontSize;
    }

    public boolean isNotificationEnabled() {
        return notificationEnabled;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "ConfigurationMemento{" +
                "theme='" + theme + '\'' +
                ", fontSize=" + fontSize +
                ", notificationEnabled=" + notificationEnabled +
                ", language='" + language + '\'' +
                '}';
    }
}
