package com.example.lucassales.marvel.data.mapper;

import com.example.lucassales.marvel.data.db.entity.Comic;
import com.example.lucassales.marvel.data.network.dto.ComicDTO;
import com.example.lucassales.marvel.data.network.dto.Image;
import com.example.lucassales.marvel.data.network.dto.Item;

import java.util.List;

/**
 * Created by lucassales on 30/11/2017.
 */

public class EntityMapper {

    public static Comic mapToEntity(ComicDTO dto) {
        Image image;
        if (dto.getImages().isEmpty()) {
            image = dto.getThumbnail();
        } else {
            image = dto.getImages().get(0);
        }

        StringBuilder builder = new StringBuilder();
        List<Item> items = dto.getCreators().getItems();
        if (items != null && !items.isEmpty()) {
            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                if (i > 0) {
                    builder.append(", ");
                }
                builder.append(item.getName());
            }
        } else {
            builder.append("-");
        }

        return new Comic(
                Long.valueOf(dto.getId()),
                dto.getTitle(),
                dto.getDescription(),
                image.getPath() + "." + image.getExtension(),
                Float.valueOf(dto.getPrices().get(0).getPrice()),
                Integer.valueOf(dto.getPageCount()),
                builder.toString());
    }

}
