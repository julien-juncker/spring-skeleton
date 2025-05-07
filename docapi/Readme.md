# Docapi-template
The official template to set a docAPI site (API Documentation).
To run it locally, perform these steps :

Only for the first installation: 
- `git submodule add --depth 1 https://github.com/McShelby/hugo-theme-relearn.git docapi/themes/hugo-theme-relearn` in root folder
- `brew install hugo`

To launch the server locally:
- `hugo server` in docapi folder
- Go to http://localhost:1313/

If you have this error : 
```bash
Error: error building site: process: readAndProcessContent: ".../spring-skeleton/docapi/content/openapi.md:6:1": failed to extract shortcode: template for shortcode "openapi" not found
```
Run this command : 
```bash 
git submodule update --init --recursive
```