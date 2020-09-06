#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'
    }
    stages {
        stage("Build Maven") {
            steps {
                bat 'mvn -B clean package'
            }
        }
        stage("Maven Tests") {
             steps {
                bat 'mvn -B test'
            }
        }

    }
}