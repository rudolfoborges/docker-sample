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
            apiImage = docker.build('docker-sample-api', 'docker-sample-api')
        }


        stage(name: "Docker Push Image"){
            docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                apiImage.push("${version}")
                apiImage.push("latest")
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