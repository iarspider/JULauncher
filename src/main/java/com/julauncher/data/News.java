/*
 * JULauncher - https://github.com/iarspider/JULauncher
 * Copyright (C) 2015 JULauncher
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.julauncher.data;

import com.julauncher.annot.Json;

/**
 * News class contains a single news article.
 */
@Json
public class News {
    /**
     * The title of this news article.
     */
    private String title;

    /**
     * The number of comments on this news article.
     */
    private int comments;

    /**
     * The link to this news article.
     */
    private String link;

    /**
     * The content of this news article.
     */
    private String content;

    /**
     * Gets the HTML of this object.
     */
    public String getHTML() {
        return "<p id=\"newsHeader\">- <a href=\"" + this.link + "\">" + this.title + "</a> (" + this.comments + " "
                + (this.comments == 1 ? "comment" : "comments") + ")</p>" + "<p id=\"newsBody\">" + this.content +
                "</p><br/>";
    }
}
