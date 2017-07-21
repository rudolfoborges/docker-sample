#!groovy

node {

    withEnv(["JAVA_HOME=/opt/jdk8"]) {

        deleteDir()

        def gradle = "./gradlew"

        stage(name: "Git Checkout"){
            checkout scm
        }


        stage(name: "Clean"){
            sh "${gradle} clean"
        }


        stage(name: "Build"){
            sh "${gradle} build"
        }


        stage(name: "Tests"){
            sh "${gradle} test"
        }


        def version = getVersion()

        def apiImage
        stage(name: "Docker Build Imagem"){
            sh "docker build docker-sample-api -t docker-sample-api:${version}"
            apiImage = docker.build('docker-sample-api', 'docker-sample-api')
        }


        stage(name: "Docker Push Image"){
            docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                docker tag docker-sample-api registry.hub.docker.com/rudolfoborges/docker-sample-api:0.0.1
                docker push registry.hub.docker.com/rudolfoborges/docker-sample-api:0.0.1
            }
        }


        stage(name: "Docker Deploy"){
            sh "docker stack deploy --compose-file docker-compose.yml docker-sample"
        }


    }

}



def getVersion() {
    def content = readFile(pwd() + "/gradle.properties")
    for (def line in content.split('\n')) {
        if (line =~ /version/) {
            return line.split('=')[1]
        }
    }

    return ''
}