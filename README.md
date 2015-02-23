I-love-Trains
=============
Para bajarte el proyecto tienes que abrir Git Bash, posicionarte sobre la carpeta donde quieres que se descargue, e introducir:

```
git clone https://github.com/samus24/I-love-Trains.git
```
<br />
-------------  
Para subir código al repositorio, posicionate sobre la carpeta del proyecto y ejecuta estos comandos:
```
git add src
git commit -m "tu mensaje relevante"
git push
```
Por supuesto antes te has tenido que identificar, si no no te dejará hacer el commit.
Eso se hace con estos comandos:
```
git config --global user.name "Aquí tu usuario de github"
git config --global user.email "emailQueMetisteEnTuCuentaDeGitHub@example.com"
```

<br />
Si tienes una versión de git anterior a 2.X en vez de hacer `git add src` debes poner `git add -A src`.
Si tienes algo de curiosidad sobre por qué hay que poner -A en el add, puedes leer [esto] (http://stackoverflow.com/questions/572549/difference-between-git-add-a-and-git-add).  
