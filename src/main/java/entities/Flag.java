package entities;

import javax.persistence.*;


@Table(name = "flag")
@Entity
public class Flag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "country_name", nullable = false, length = 50, unique = true)
    private String countryName;

    @Column(name = "flag_url", nullable = false, unique = true)
    private String flagURL;

    @Column(name = "answered")
    private Long answered;              // times answered

    @Column(name = "correct")
    private Long correct;               // times answered correctly

    @Column(name = "incorrect")
    private Long incorrect;             // times answered incorrectly

    public Flag() {
    }

    public Flag(String countryName, String flagURL, Long answered, Long correct, Long incorrect) {
        this.countryName = countryName;
        this.flagURL = flagURL;
        this.answered = answered;
        this.correct = correct;
        this.incorrect = incorrect;
    }

    public Flag(String countryName, String flagURL) {
        this.countryName = countryName;
        this.flagURL = flagURL;
        this.answered = 0L;
        this.correct = 0L;
        this.incorrect = 0L;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCountryName() { return countryName; }
    public void setCountryName(String countryName) { this.countryName = countryName; }
    public String getFlagURL() { return flagURL; }
    public void setFlagURL(String flagURL) { this.flagURL = flagURL; }
    public Long getAnswered() { return answered; }
    public void setAnswered(Long answered) { this.answered = answered; }
    public Long getCorrect() { return correct; }
    public void setCorrect(Long correct) { this.correct = correct; }
    public Long getIncorrect() { return incorrect; }
    public void setIncorrect(Long incorrect) { this.incorrect = incorrect; }
}