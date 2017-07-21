#!groovy

node {

    withEnv(["JAVA_HOME=/opt/jdk8"]) {

        deleteDir()

        def gradle = "./gradlew"

        stage(name: "Git Checkout", concurrency: 1){
            checkout scm
        }


        stage(name: "Clean", concurrency: 1){
            sh "${gradle} clean"
        }


        stage(name: "Build", concurrency: 1){
            sh "${gradle} build"
        }


        stage(name: "Tests", concurrency: 1){
            sh "${gradle} test"
        }


        def version = getVersion()

        def apiImage
        stage(name: "Docker Build Imagem", concurrency: 1){
            apiImage = docker.build('docker-sample-api')
        }


        stage(name: "Docker Push Image", concurrency: 1){
            docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                apiImage.push("${version}")
                apiImage.push("latest")
            }
        }


        stage(name: "Docker Deploy", concurrency: 1){
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