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

import com.julauncher.App;
import com.julauncher.Gsons;
import com.julauncher.annot.Json;
import com.julauncher.data.mojang.MojangConstants;
import com.julauncher.data.mojang.MojangVersion;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * TODO: Rewrite along with {@link com.julauncher.data.Version} {@link com.julauncher.data.LauncherVersion}
 */
@Json
public class MinecraftVersion {
    private String version;
    private boolean server;
    private boolean legacy;
    private boolean coremods;
    private boolean resources;
    private MojangVersion mojangVersion;

    public void loadVersion() {
        File versionFile = new File(App.settings.getVersionsDir(), this.version + ".json");
        if (!App.skipMinecraftVersionDownloads) {
            Downloadable download = new Downloadable(MojangConstants.DOWNLOAD_BASE.getURL("versions/" + this.version +
                    "/" + this.version + ".json"), versionFile, null, null, false);
            if (download.needToDownload()) {
                download.download(false);
            }
        }
        try {
            mojangVersion = Gsons.DEFAULT_ALT.fromJson(new FileReader(versionFile), MojangVersion.class);
        } catch (JsonSyntaxException e) {
            App.settings.logStackTrace(e);
        } catch (JsonIOException e) {
            App.settings.logStackTrace(e);
        } catch (FileNotFoundException e) {
            App.settings.logStackTrace(e);
        }
    }

    public boolean canCreateServer() {
        return this.server;
    }

    public String getVersion() {
        return this.version;
    }

    public MojangVersion getMojangVersion() {
        return this.mojangVersion;
    }

    public boolean isLegacy() {
        return this.legacy;
    }

    public boolean usesCoreMods() {
        return this.coremods;
    }

    public boolean hasResources() {
        return this.resources;
    }

    public String toString() {
        return this.version;
    }

}