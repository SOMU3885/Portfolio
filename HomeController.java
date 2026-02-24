package com.ragasomeshkumar.Portfolio.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/projects")
    public String projects(Model model) {
        // Create a data object for your project
        ProjectData myProject = new ProjectData(
            "Portfolio Website", 
            "A personal portfolio built with Spring Boot and Thymeleaf",
            "This project was designed to showcase my skills in Java backend development. I implemented a clean MVC architecture and integrated Thymeleaf for dynamic content rendering.",
            "/img.jpg", // Ensure this exists in src/main/resources/static/
            Arrays.asList("Java", "Spring Boot", "Thymeleaf", "HTML/CSS"),
            "Web Development",
            "Feb 2026",
            "https://your-demo-link.com",
            "https://github.com/your-username/repo"
        );

        // Add to model. Name "project" MUST match the HTML
        model.addAttribute("project", myProject);

        return "projects";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    // Inner class to structure project data
    public static class ProjectData {
        private String name;
        private String tagline;
        private String description;
        private String imageUrl;
        private List<String> technologies;
        private String category;
        private String date;
        private String liveUrl;
        private String githubUrl;

        public ProjectData(String name, String tagline, String description, String imageUrl, 
                           List<String> technologies, String category, String date, 
                           String liveUrl, String githubUrl) {
            this.name = name;
            this.tagline = tagline;
            this.description = description;
            this.imageUrl = imageUrl;
            this.technologies = technologies;
            this.category = category;
            this.date = date;
            this.liveUrl = liveUrl;
            this.githubUrl = githubUrl;
        }

        // GETTERS - Thymeleaf needs these to access the data!
        public String getName() { return name; }
        public String getTagline() { return tagline; }
        public String getDescription() { return description; }
        public String getImageUrl() { return imageUrl; }
        public List<String> getTechnologies() { return technologies; }
        public String getCategory() { return category; }
        public String getDate() { return date; }
        public String getLiveUrl() { return liveUrl; }
        public String getGithubUrl() { return githubUrl; }
    }
}