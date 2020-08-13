package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "autos")
public class Auto {

//    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column
    private String name;

    @Id
    @Column
    private int series;

    @OneToOne(optional = true, mappedBy = "auto", fetch = FetchType.EAGER )
    private User user;

    public Auto() {}

    public Auto(String name, int series) {
        this.name = name;
        this.series = series;
    }

//    public Long getId() { return id;}

    public String getName() { return name;}

    public void setName(String name) { this.name = name;}

    public int getSeries() { return series;}

    public void setSeries(int series) { this.series = series;}

    public String toString() { return this.name + " - "+ this.series;}




}
