/*
 * Copyright (C) 2026 Sxtormulo
 * SPDX-License-Identifier: GPL-3.0-or-later
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

module dukes.greeting {
    requires jakarta.persistence;
    requires jakarta.inject;
    requires jakarta.ejb;
    requires jakarta.servlet;
    requires jakarta.cdi;
    requires static jakarta.transaction;
    requires static jakarta.cdi.lang.model;
    requires static jakarta.annotation;
    requires static jakarta.interceptor;
    exports dukes.greeting;
}
