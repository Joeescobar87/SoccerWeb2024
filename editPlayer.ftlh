<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>BootLab 8</title>
    <style>


        footer{
            text-align: center;

        }

    </style>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
    />
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css"
    />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@5.3.2/dist/sketchy/bootstrap.min.css">
</head>
<body class="p-3">

<nav class="navbar navbar-expand-lg bg-light" data-bs-theme="light">
    <div class="container-fluid">

        <a class="navbar-brand pt-1" href="#"
        ><i class="bi bi-globe d-inline" style="font-size: 1.3em"
            > </i>Hurricanes Soccer Academy</a>
        <button
                class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link text-primary-emphasis" href="/root">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/players">Players</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/teams">Teams</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<br>
<h1 class="text-body-secondary">Edit Players</h1>
<form  method='post'>


    <label class="col-form-label col-form-label-lg " for="name">Name:</label>
    <input class="form-control form-control-lg text-body-tertiary" type="text"  id="name" name="name" value="${player.name}">

    <label for="birthYear"  class="form-label mt-4">Birth Year:</label>
    <select class="form-select" id="birthYear" name="birthYear"  >
        <option value="${player.birthYear?string["0"]}" selected hidden >
            ${player.birthYear?string["0"]}
        </option>
        <option> ${(year-12)?string["0"]}</option>
        <option> ${(year-11)?string["0"]}</option>
        <option> ${(year-10)?string["0"]}</option>
        <option> ${(year-9)?string["0"]}</option>
        <option> ${(year-8)?string["0"]}</option>
        <option> ${(year-7)?string["0"]}</option>
        <option> ${(year-6)?string["0"]}</option>
        <option> ${(year-5)?string["0"]}</option>
        <option> ${(year-4)?string["0"]}</option>
    </select>

    <br>
    <#if player.gender=="M">
        <input type=radio checked id='male' name='gender' value=M>
        <label for='male'>M</label>
        <input type=radio  id='female' name='gender' value=F>
        <label for='female'>F</label>
        <br>
    <#else>
        <input type=radio id='male' name='gender' value=M>
        <label for='male'>M</label>
        <input type=radio   checked id='female' name='gender' value=F>
        <label for='female'>F</label>
        <br>
    </#if>





    <label for="team"  class="form-label mt-4">Team:</label>
    <select class="form-select" id="team" name="team"  >
        <option value="-1">Empty</option>
        <#list team as t>
        <#if player.gender==t.gender>
            <#if t.minAge lte player.age && t.maxAge gte player.age>
                <option>${t.id}</option>
            </#if>
        </#if>
        </#list>
    </select>

    <br>
    <button type="button" class="btn btn-secondary" onclick="window.location.href='players'">Cancel</button>
    <button type="submit" class="btn btn-primary">Add</button>

</form>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"
></script>
</body>
<footer class="p-4">

    <div style= "font-size:23px">Hurricanes Soccer Academy - Serving Claremont and Surrounding Areas</div>
</footer>

</html>