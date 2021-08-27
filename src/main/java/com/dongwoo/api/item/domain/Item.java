package com.dongwoo.api.item.domain;

import com.dongwoo.api.order.domain.Order;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_brand")
    private String itemBrand;

    @Column(name = "model_no")
    private String modelNo;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_color")
    private String itemColor;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "sold_out")
    private Boolean soldOut;

    @OneToMany(mappedBy = "item")
    private List<Order> orders = new ArrayList<>();

    @Builder
    public Item(String itemBrand, String itemName, String itemColor) {
        this.itemBrand = itemBrand;
        this.itemName = itemName;
        this.itemColor = itemColor;
    }
}
