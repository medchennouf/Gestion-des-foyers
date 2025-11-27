FROM python:3.12-slim

# Create non-root user
ENV APP_USER=appuser
RUN useradd -m -s /bin/bash $APP_USER

WORKDIR /app

# Copy only necessary files
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

COPY . .

# Use non-root user
USER $APP_USER

# Expose and default command (adapt to ton app)
EXPOSE 8080
CMD ["python", "app.py"]

