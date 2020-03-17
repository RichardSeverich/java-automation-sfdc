package org.fundacionjala.sfdc.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class that gets the Environment config.
 */
public final class Env {

    private static final Logger LOGGER = LogManager.getLogger();

    private static Env instance;

    private Properties properties;

    /**
     * Private constructor for Env.
     */
    private Env() {
        try (FileInputStream input = new FileInputStream("gradle.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (FileNotFoundException e) {
            LOGGER.error("File not found.");
            LOGGER.info(e);
            throw new MyRuntimeException("File not found.", e);
        } catch (IOException e) {
            LOGGER.error("File broken.");
            LOGGER.info(e);
            throw new MyRuntimeException("File broken.", e);
        }
    }

    /**
     * Returns the Instance for Env.
     *
     * @return Env instance.
     */
    public static Env getInstance() {
        if (instance == null) {
            instance = new Env();
        }
        return instance;
    }

    /**
     * Gets Env Properties.
     *
     * @param env String option.
     * @return String result.
     */
    public String getEnv(String env) {
        String property = System.getProperty(env);
        if (property == null) {
            return properties.getProperty(env);
        }
        return property;
    }

    /**
     * Gets the Username value.
     *
     * @return String.
     */
    public String getUsername() {
        return getEnv("username");
    }

    /**
     * Gets the Password value.
     *
     * @return String.
     */
    public String getPassword() {
        return getEnv("password");
    }

    /**
     * Gets the Base Url of Sales Force.
     *
     * @return String.
     */
    public String getBaseUrl() {
        return getEnv("baseUrl");
    }

    /**
     * Gets the Login Url of Sales Force.
     *
     * @return String.
     */
    public String getLoginUrl() {
        return getEnv("loginUrl");
    }

    /**
     * Gets the Browser to use.
     *
     * @return String.
     */
    public String getBrowser() {
        return getEnv("browser");
    }

    /**
     * Gets the type Browser to use.
     *
     * @return String.
     */
    public String getRemoteBrowser() {
        return getEnv("remoteBrowser");
    }

    /**
     * Gets the version Browser to use.
     *
     * @return String.
     */
    public String getRemoteBrowserVersion() {
        return getEnv("remoteBrowserVersion");
    }

    /**
     * Gets the operative system to use.
     *
     * @return String.
     */
    public String getRemotePlatform() {
        return getEnv("remotePlatform");
    }

    /**
     * Gets the version operative system to use.
     *
     * @return String.
     */
    public String getRemotePlatformVersion() {
        return getEnv("remotePlatformVersion");
    }

    /**
     * Gets the resolution to use.
     *
     * @return String.
     */
    public String getRemoteResolution() {
        return getEnv("remoteResolution");
    }

    /**
     * Gets the remote user name to use.
     *
     * @return String.
     */
    public String getRemoteUserName() {
        return getEnv("remoteUserName");
    }

    /**
     * Gets the remote user key to use.
     *
     * @return String.
     */
    public String getRemoteKey() {
        return getEnv("remoteKey");
    }

    /**
     * Gets the Docker Url to use.
     *
     * @return String.
     */
    public String getDockerUrl() {
        return getEnv("dockerUrl");
    }

    /**
     * Gets the Implicit Time Wait.
     *
     * @return the value of implicit time wait.
     */
    public int getImplicitTimeWait() {
        return Integer.parseInt(getEnv("implicitTimeWait"));
    }

    /**
     * Gets the ExplicitT Time Wait.
     *
     * @return the value of explicit time wait.
     */
    public int getExplicitTimeWait() {
        return Integer.parseInt(getEnv("explicitTimeWait"));
    }
}
