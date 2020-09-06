#!/usr/bin/env groovy

pipeline {
    agent any
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