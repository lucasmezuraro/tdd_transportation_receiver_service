#!/usr/bin/env groovy
import org.apache.commons.lang.SystemUtils

pipeline {
    agent any
    stages {
        stage("Build Maven") {
            steps {
                if (SystemUtils.IS_OS_WINDOWS) {
                    bat 'mvn -B clean package'
                }else {
                    sh 'mvn -B clean package'
                }
            }
        }
        stage("Maven Tests") {
             steps {
                if (SystemUtils.IS_OS_WINDOWS) {
                    bat 'mvn -B test'
                }else {
                    sh 'mvn -B test'
                }
            }
        }

    }
}