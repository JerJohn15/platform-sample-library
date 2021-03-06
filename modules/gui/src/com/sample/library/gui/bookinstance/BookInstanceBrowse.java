/*
 * Copyright (c) 2015 Haulmont
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sample.library.gui.bookinstance;

import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.Table;
import com.sample.library.entity.BookInstance;
import com.sample.library.entity.BookPublication;
import com.sample.library.gui.components.AssignLibraryDepartmentAction;

import javax.inject.Inject;
import java.util.Map;

public class BookInstanceBrowse extends AbstractLookup {

    @Inject
    private Table<BookInstance> bookInstanceTable;

    @Inject
    private Label bookTitleLabel;

    @WindowParam(name = "bookPublication", required = true)
    private BookPublication publication;

    @Override
    public void init(Map<String, Object> params) {
        addAction(new AssignLibraryDepartmentAction(bookInstanceTable));

        bookTitleLabel.setValue(String.format(getMessage("book"),
                publication.getBook().getName(), publication.getPublisher().getName(), publication.getYear()));
    }
}