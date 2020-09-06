#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage("Build Maven") {
            steps {
                if (isUnix()) {
                    sh 'mvn -B clean package'
                }else {
                    bat 'mvn -B clean package'
                }
            }
        }
        stage("Maven Tests") {
             steps {
                if (isUnix()) {
                    sh 'mvn -B test'
                }else {
                    bat 'mvn -B test'
                }
            }
        }

    }
}